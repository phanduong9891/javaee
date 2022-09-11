package service.dao;


import entity.Department;
import resource.request.DepartmentRequest;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class DepartmentDAOImpl implements DepartmentDAO{

    @PersistenceContext(name = "Company")
    EntityManager entityManager;


    @Override
    public List<Department> findAll() {
        Query allDepartmentQuery = entityManager.createQuery("SELECT d FROM Department d", Department.class);
        return allDepartmentQuery.getResultList();
    }

    @Override
    public Department create(DepartmentRequest departmentRequest) {
        Department department = new Department();
        department.setDepartmentName(departmentRequest.getDepartmentName());
        department.setStartDate(departmentRequest.getLocalDate());
        department = this.entityManager.merge(department);
        return department;
    }

    @Override
    public Department update(Integer departmentId,DepartmentRequest departmentRequest) {
        Department updateDepartment = findById(departmentId);
        //what if cant find
        updateDepartment.setDepartmentName(departmentRequest.getDepartmentName());
        updateDepartment.setStartDate(departmentRequest.getLocalDate());
        updateDepartment = this.entityManager.merge(updateDepartment);

        return updateDepartment;
    }

    @Override
    public Department findById(Integer departmentId) {
        return  entityManager.createQuery("SELECT D FROM Department d WHERE d.departmentId = :departmentId", Department.class)
                .setParameter("departmentId",departmentId).getSingleResult();
    }

    @Override
    public void remove(Integer departmentId) {
        Department department = findById(departmentId);
        if(null != department)
            this.entityManager.remove(department);
    }

}
