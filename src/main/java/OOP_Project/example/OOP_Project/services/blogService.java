
package OOP_Project.example.OOP_Project.services;

import OOP_Project.example.OOP_Project.models.BlogModel;
import java.util.List;


public interface blogService {
    List<BlogModel> getAllBlogs(); // lấy tất cả các bài viết BlogModel
    
    BlogModel getBlogById(Integer id);// lấy 1 bài viết BlogModel dựa trên ID
    
    BlogModel saveBlog(BlogModel blog);// Lưu hoặc cập nhật một bài viết BlogModel
    
    Boolean delete (BlogModel blog);// Xóa một bài viết BlogModel dựa trên ID
    
    Boolean create (BlogModel blog); //tạo mới một bài viết BlogModel
    
    Boolean update (BlogModel blog);
    
    List<BlogModel> getItem();
    
    BlogModel getItemSlug(String slug);
}
