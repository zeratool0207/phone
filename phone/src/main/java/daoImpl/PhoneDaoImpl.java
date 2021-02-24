package daoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.PhoneDao;

@Repository
public class PhoneDaoImpl implements PhoneDao{
	
	@Autowired
	SqlSession sqlsession;
	
	private static final String NameSpace = "com.mappers.phoneMapper.";

	@Override
	public List<Map<String, Object>> list(Map<String,Object> map) {
		return sqlsession.selectList(NameSpace+"list",map);
	}

	@Override
	public int insert(Map<String, Object> map) {
		return sqlsession.insert(NameSpace+"insert",map);
	}

	@Override
	public Map<String, Object> detail(int seq) {
		return sqlsession.selectOne(NameSpace+"detail",seq);
	}

	@Override
	public int update(Map<String, Object> map) {
		return sqlsession.update(NameSpace+"update",map);
	}

	@Override
	public int delete(List<Integer> list) {
		return sqlsession.update(NameSpace+"delete",list);
	}

	@Override
	public int totalRowCount() {
		return sqlsession.selectOne(NameSpace+"totalRowCount");
	}

	

}
