import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

  // 根据id查询用户
  @Test
  public void queryUserById(){
    SqlSession session1 = MybatisUtils.getSqlSession();
    SqlSession session2 = MybatisUtils.getSqlSession();

    UserMapper mapper1 = session1.getMapper(UserMapper.class);
    User user1 = mapper1.queryUserById(1);
    System.out.println(user1);

    session1.close();

    System.out.println("================================");
    UserMapper mapper2 = session2.getMapper(UserMapper.class);
    User user2 = mapper2.queryUserById(1);
    System.out.println(user2);

    System.out.println(user1 == user2);


    session2.close();
  }
}
