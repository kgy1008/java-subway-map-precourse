# 지하철 노선도 미션

## 기능 요구사항

### 지하철 역

- [x] 지하철 역을 등록하고 삭제할 수 있다.
    - [x] 이름이 중복된 지하철 역을 등록할 수 없다.
    - [x] 지하철 역 이름은 2글자 이상이여야 한다.
    - [x] 노선에 등록된 역은 삭제할 수 없다.
- [x] 지하철 역의 목록을 조회할 수 있다.

### 지하철 노선

- [ ] 지하철 노선을 등록하고 삭제할 수 있다.
    - [ ] 노선 등록 시, 상행 종점역과 하행 종점역을 입력받는다.
        - [x] 이름이 중복된 지하철 노선을 등록할 수 없다.
        - [x] 지하철 노선 이름은 2글자 이상이여야 한다.
        - [x] 노선에 등록된 역이 존재하면, 노선을 삭제할 수 없다.
- [x] 지하철 노선 목록을 조회할 수 있다.

### 지하철 구간

- [ ] 지하철 노선에 구간을 추가할 수 있다. (= 노선에 역을 추가할 수 있다.)
    - [ ] 하나의 역은 여러개의 노선에 추가될 수 있다.
    - [ ] 역과 역 사이에 새로운 노선이 추가될 수 있다.
    - [ ] 노선에서 갈래길은 생길 수 없다.
- [ ] 지하철 노선에 구간을 삭제할 수 있다. (= 노선에 등록된 역을 제거할 수 있다.)
    - [ ] 종점을 제거할 경우 다음 역이 종점이 된다.
    - [ ] 노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없다.
- [ ] 노선의 상행 종점부터 하행 종점까지 연결된 순서대로 역 목록을 조회할 수 있다.

### 출력

- [ ] 기대하는 출력 결과는 [INFO]를 붙여서 출력한다.
- [ ] 에러 발생 시 [ERROR]를 붙여서 출력한다.
