
package OOP_Project.example.OOP_Project.services;

import OOP_Project.example.OOP_Project.models.blogCategoryModel;
import java.util.List;

public interface blogCateService {
    List<blogCategoryModel> getAllblogCategories();

    blogCategoryModel getblogCategoryById(Integer id);

    blogCategoryModel saveblogCategory(blogCategoryModel blogCategory);

    Boolean delete (blogCategoryModel blogCategory);

    Boolean create(blogCategoryModel blogCategory);

    Boolean update (blogCategoryModel blogCategory);
}
