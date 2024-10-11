
package OOP_Project.example.OOP_Project.services;

import OOP_Project.example.OOP_Project.models.blogCategoryModel;
import java.util.List;

public interface blogCateService {
    List<blogCategoryModel> getAllCategories();
    blogCategoryModel getCategoryById(int id);
    blogCategoryModel saveCategory(blogCategoryModel blogCategory);
    void deleteCategory(int id);

    Boolean create(blogCategoryModel blogCategory);
}
