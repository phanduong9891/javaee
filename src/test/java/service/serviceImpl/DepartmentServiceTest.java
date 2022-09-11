package service.serviceImpl;

import entity.Department;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import resource.request.DepartmentRequest;
import service.dao.DepartmentDAO;
import service.dto.DepartmentDto;
import service.mapper.DepartmentMapper;

import javax.inject.Inject;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @InjectMocks
    private DepartmentService departmentService;

    @Mock
    private DepartmentDAO departmentDAO;

    @Mock
    private DepartmentMapper departmentMapper;


    @Test
    void save() {
        Department department = new Department();
        department.setDepartmentName("IT");
        department.setStartDate(LocalDate.of(2022,5,1));

        DepartmentRequest departmentRequest = new DepartmentRequest();
        departmentRequest.setDepartmentName("IT");
        departmentRequest.setLocalDate(LocalDate.of(2022,5,1));

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentId(1);
        departmentDto.setDepartmentName("IT");
        departmentDto.setStartDate(LocalDate.of(2022,5,1));

        when(departmentDAO.create(departmentRequest)).thenReturn(department);
        when(departmentMapper.toDto(department)).thenReturn(departmentDto);

        DepartmentDto resultDepartment = departmentService.save(departmentRequest);

        assertEquals(departmentDto.getDepartmentName(), resultDepartment.getDepartmentName());

    }
}