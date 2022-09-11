package service.serviceImpl;

import resource.request.DepartmentRequest;
import service.dao.DepartmentDAO;
import service.dto.DepartmentDto;
import service.mapper.DepartmentMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class DepartmentService {

    @Inject
    private DepartmentDAO departmentDAO;

    @Inject
    private DepartmentMapper departmentMapper;

    public List<DepartmentDto> getAll(){
        return departmentMapper.toDtos(departmentDAO.findAll());
    }

    public DepartmentDto save(DepartmentRequest departmentRequest){
        return departmentMapper.toDto(departmentDAO.create(departmentRequest));
    }

    public DepartmentDto update(Integer departmentId, DepartmentRequest departmentRequest){
        return departmentMapper.toDto(departmentDAO.update(departmentId,departmentRequest));
    }

    public void remove(Integer departmentId){
        departmentDAO.remove(departmentId);
    }
}
