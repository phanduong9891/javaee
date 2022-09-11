package service.dao;

import entity.Department;
import resource.request.DepartmentRequest;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public interface DepartmentDAO {

    List<Department> findAll();

    Department create(DepartmentRequest departmentRequest);

    Department update(Integer departmentId, DepartmentRequest departmentRequest);

    Department findById(Integer departmentId);

    void remove(Integer departmentId);
}
