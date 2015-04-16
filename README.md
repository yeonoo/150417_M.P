### info
 - DB 117.17.102.143
 - jdbc:mysql://117.17.102.143/spring
 - id : root / pw : Starter
 - 1046339528

### 과정
1. 정보를 주면 사용자 조회하는 DAO 만들어 주세요.
 - 조회 하기 위해서 테스트 케이스 만들고

2. DB에 직접 등록 불편
 - 사용자 추가기능 만들기 (중복발생)

3. D사 N사 구분해서 납품하게 DB를 별도로 만들기 (상속 기반 추상화가 들어감)
 - template method pattern 만들기 (변경되는 부분/변경되지 않는 부분)
  - 뭐가 들어갈지 모르면 abstract로 만듬
  - hook은 변하지 않는 것. abstract는 변하는 것
  - extend해서 변하는 걸 정의
 - Factory method (상속 기반 추상화)

4. 상품을 조회, 등록하고 싶음 
 - Strategy Pattern
  변하는 게 전략
  추상화 레벨을 클래스까지 올려서 사용

5. 추상화해서 만든건 좋은데 메이커들이 dependency를 가지고 있어서 불편
 - daofactory -> Spring Container (Application Context)
 - 클라이언트한테 생성자를 통해서 던졌는데
  클라이언트도 instant 만드는 factory에 다시 던짐 - 그래서 만들어진게 DaoFactory
  팩토리처럼 의존성을 주입해서 주는 방식이 DI(Dependency Injection)
 - Bean : Spring Container 가 관리한 Java object (UserDao)
 - Sping의 핵심 코어를 만듬

6. 장애 발생 - dao를 사용하는데, 서버가 가끔 죽어
 - Close 되는 부분의 문제
 - 커넥션을 계속 물고 Close가 안됨
  - try catch문으로 감쌈 (복잡한 구조로 만듬)

7. 사용자 삭제하는 거 만들어줘
 - copy & paste 함.... 
  - 근데 여기서 로직 틀어졌다가는 복사한 개수만큼 변경 발생 ㅠㅠ

8. 요거 마술 부려서 예쁘고 깔끔하게 만들자


시험 참고
=======
1. 테스트 케이스 만들고
 - 요구사항에 대한 패턴 만들고
 - 개발에 필요한 것들을 넣음
 - userDao_get1 / userDao_get2
 - get만 딜리버리하면 문제 없음

2. 요구사항 들어옴
 - add/refactoring
 - 사용자 추가해 달래 -> copy & paste 함
  - 같은 부분이 있다. (커넥션 얻어오는 부분이 똑같음)
  - getConnection이라고 해서 메소드를 분리 (리팩토링!! 중복 제거하자)

3. D사에서 납품하는데 N사에서도 납품하고 싶다.
 - 커넥션하는 DB가 달라질 수 있음. 정보 달라지는 걸 확인
  - 코드에 녹여서 다 딜리버리하자. (어느 회사가 들어오든)
  - 변하는 것과 변하지 않는 것이 보임
 - 커넥션 / 추상화 (1. 메소드로 분리, 2. abstrat로 만들기)
  -getConnettion 자체를 abstract
 - 메소드 추상화 함
 - 상속을 통해 implementation을 함
 - NUserDao DUserDao를 UserDao로 추상화 (템플릿 메소드 패턴 / 팩토리 메소드 패턴)
  - 상속 기반 추상화 개념 - 템플릿 메소드 
 - UserDao_FactorymethodPattern.mov
 
4. 상품 하나 추가해줘
 - userDao_strategypattern
 - 커넥션 메이커 인터페이스 만들어서
 - abstract한걸 인터페이스에 프로덕트가 각 커넥션을 상속 받을 수 잇게 함
 - 클래스 레벨로 추상화 하는게 (전략패턴)
  - 변하지 않는 부분들을 그대로 놔두고
  - 변하는 부분들을 추상화를 클래스 레벨로 함
  - implement로 하는게 전략

5. D커넥션메이커인지 N커넥션메이커인지 매번 구분..
 - 커넥션 메이커를 생성자에 두고 클라이언트들에게 니들이 구분해서 줘라라고 요구
  - (디펜던시 없애려고..)
 - 클라이언트도 귀찮아 - > DaoFactory.mov 팩토리를 만듬
  - (인스턴스를 결정할 수 있는 일을 줌 / 의존성을 니가 알아서 주입해서 우리에게 줘라 -> 팩토리 패턴)

6. SpringDaoFactory1/2


동영상 순서
=======
 - userDao_get1
 - userDao_get2
 - userDao_add
 - userDao_refactoring1
 - userDao_factorymethodpattern
 - userDao_strategypattern
 - DaoFactory
 - SrpingDaoFactory1
 - SpringDaoFactory2
 - DataSource
 - userDao_exception
 - userDao_delete
 - userDao_makestatement
 - jdbcContext
 - template_callback
 - jdbcTemplate1
 - jdbcTemplate2
