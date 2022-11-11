package cms.SchedulePackage;

/**
 * 작성자: 정수연 기능: 실습실 상태 조회
 */
public interface SearchState {

    Object[][] row = new Object[8][5]; //String, 이미지도 줘야되기때문에 Object씀////////

    public void search();
}
