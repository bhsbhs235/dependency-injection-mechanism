# DI(Dependency Injection) Frameworke Mechanism

스프링 프레임워크의 핵심 프로그래밍 모델인 의존성 주입 DI의 원리의 기초를 작성한 프로젝트

@Autowired

MessageRepository messageRepository;

@Autowired 애노테이션만 추가했는데 messageRepository가 null이 아닌 이유는 스프링 프레임워크 Reflection을 사용해서 class instance를 생성해서 주입해주기 때문이다

## 프로젝트 설명
해당 프로젝트를 배포한 후 임포트하면 @Inject 애노테이션을 붙여준 필드는 자동으로 class instance가 생성되 해당 클래스의 함수를 쓸 수 있으며, null도 아니다.



