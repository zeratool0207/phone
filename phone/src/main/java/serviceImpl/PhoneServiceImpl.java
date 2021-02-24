package serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PhoneDao;
import service.PhoneService;

@Service
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	PhoneDao dao;

	@Override
	public List<Map<String, Object>> list(Map<String,Object> map) {
		return dao.list(map);
	}

	@Override
	public int insert(Map<String, Object> map) {
		return dao.insert(map);
	}

	@Override
	public Map<String, Object> detail(int seq) {
		return dao.detail(seq);
	}

	@Override
	public int update(Map<String, Object> map) {
		return dao.update(map);
	}

	@Override
	public int delete(List<Integer> list) {
		return dao.delete(list);
	}

	@Override
	public int totalRowCount() {
		return dao.totalRowCount();
	}
}
