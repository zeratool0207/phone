package service;

import java.util.List;
import java.util.Map;

public interface PhoneService {

	//List<Map<String, Object>> list();

	int insert(Map<String, Object> map);

	Map<String, Object> detail(int seq);

	int update(Map<String, Object> map);

	int delete(List<Integer> list);
	
	List<Map<String, Object>> list(Map<String,Object> map);

	int totalRowCount();
	

}
