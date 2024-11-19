# 지하철 노선도 미션

## 🚀 기능 요구사항

### 초기 세팅

- [x] 프로그램 시작 시 역, 노선 등 필요한 정보를 미리 세팅한다.
    - 지하철 역 : 교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역
    - 노선: 2호선, 3호선, 신분당선
    - 구간
        - 2호선: 교대역 - 강남역 - 역삼역
        - 3호선: 교대역 - 남부터미널역 - 양재역 - 매봉역
        - 신분당선: 강남역 - 양재역 - 양재시민의숲역

### 지하철 역 관련 기능

- [x] 지하철 역을 등록할 수 있다.
- [x] 지하철 역을 삭제할 수 있다. (단, 노선에 등록된 역은 삭제할 수 없다)
- [x] 중복된 지하철 역 이름이 등록될 수 없다.
- [x] 지하철 역 이름은 2글자 이상이어야 한다.
- [x] 지하철 역의 목록을 조회할 수 있다.

### 지하철 노선 관련 기능

- [x] 지하철 노선을 등록할 수 있다.
    - [x] 노선 등록 시 상행 종점역과 하행 종점역을 입력받는다.
- [x] 지하철 노선을 삭제할 수 있다. (단, 노선에 등록된 역이 존재할 경우, 삭제할 수 없다)
- [x] 중복된 지하철 노선 이름이 등록될 수 없다.
- [x] 지하철 노선 이름은 2글자 이상이어야 한다.
- [x] 지하철 노선의 목록을 조회할 수 있다.

### 지하철 구간 추가 기능

- [x] 지하철 노선에 구간을 추가하는 기능은 노선에 역을 추가하는 기능이라고도 할 수 있다.
    - [x] 역과 역사이를 구간이라 하고 이 구간들의 모음이 노선이다.
- [x] 하나의 역은 여러개의 노선에 추가될 수 있다.
- [x] 역과 역 사이에 새로운 역이 추가 될 수 있다.
- [ ] 노선에서 갈래길은 생길 수 없다.

### 지하철 구간 삭제 기능

- [x] 노선에 등록된 역을 제거할 수 있다.
- [x] 종점을 제거할 경우 다음 역이 종점이 된다.
- [x] 노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없다.

### 지하철 노선에 등록된 역 조회 기능

- [ ] 노선의 상행 종점부터 하행 종점까지 연결된 순서대로 역 목록을 조회할 수 있다.

## ✍🏻 입출력 요구사항

- [x] 기대하는 출력 결과는 `[INFO]`를 붙여서 출력한다. 출력값의 형식은 예시와 동일하게 한다.
- [x] 에러 발생 시 `[ERROR]`를 붙여서 출력한다. (에러의 문구는 자유롭게 작성한다.)

