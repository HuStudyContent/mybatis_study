import com.kuang.dao.BlogMapper;
import com.kuang.pojo.Blog;
import com.kuang.utils.IDutils;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {

  @Test
  public void addInitBlog(){
    SqlSession session = MybatisUtils.getSqlSession();
    BlogMapper mapper = session.getMapper(BlogMapper.class);

    Blog blog = new Blog();
    blog.setId(IDutils.getId());
    blog.setTitle("Mybatis真得好难");
    blog.setAuthor("狂神");
    blog.setCreateTime(new Date());
    blog.setViews(999999999);
    mapper.addBlog(blog);

    blog.setId(IDutils.getId());
    blog.setTitle("Java真得好难");
    mapper.addBlog(blog);

    blog.setId(IDutils.getId());
    blog.setTitle("Spring真得好难");
    mapper.addBlog(blog);

    blog.setId(IDutils.getId());
    blog.setTitle("Java 微服务真得好难");
    mapper.addBlog(blog);

    session.close();

  }

  //查询
  @Test
  public void queryBlogIF(){
    SqlSession session = MybatisUtils.getSqlSession();
    BlogMapper mapper = session.getMapper(BlogMapper.class);

    HashMap map = new HashMap();
//    map.put("title", "Spring真得好难");
    map.put("author", "狂神");
    List<Blog> blogs = mapper.queryBlogIF(map);

    for(Blog blog: blogs){
      System.out.println(blog);
    }

    session.close();
  }

  // choose查询
  @Test
  public void queryBlogChoose(){
    SqlSession session = MybatisUtils.getSqlSession();
    BlogMapper mapper = session.getMapper(BlogMapper.class);

    HashMap map = new HashMap();
//    map.put("title", "Spring真得好难");
    map.put("author", "狂神");
    mapper.queryBlogChoose(map);

    session.close();
  }

  // 更新博客
  @Test
  public void updateBlog(){
    SqlSession session = MybatisUtils.getSqlSession();
    BlogMapper mapper = session.getMapper(BlogMapper.class);

    HashMap map = new HashMap();
    map.put("title", "尚硅谷");
    map.put("author", "尚硅谷");
    map.put("id", "0239376e21134b63bee88fd76d337334");

    mapper.updateBlog(map);

    session.close();
  }

  // foreach查询
  @Test
  public void queryBlogForeach(){
    SqlSession session = MybatisUtils.getSqlSession();
    BlogMapper mapper = session.getMapper(BlogMapper.class);

    //new  一个数组
    ArrayList<Integer> ids = new ArrayList<Integer>();
    ids.add(1);
    ids.add(2);
    ids.add(3);

    HashMap map = new HashMap();
    map.put("ids", ids);

    List<Blog> blogs = mapper.queryBlogForeach(map);

    for (Blog blog : blogs) {
      System.out.println(blog);
    }

    session.close();

  }
}
