package service.mapper;

import entity.Department;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import service.dto.DepartmentDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-09T20:49:48+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.15 (Amazon.com Inc.)"
)
@ApplicationScoped
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentDto toDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setDepartmentId( department.getDepartmentId() );
        departmentDto.setDepartmentName( department.getDepartmentName() );
        departmentDto.setStartDate( department.getStartDate() );

        return departmentDto;
    }

    @Override
    public List<DepartmentDto> toDtos(List<Department> departments) {
        if ( departments == null ) {
            return null;
        }

        List<DepartmentDto> list = new ArrayList<DepartmentDto>( departments.size() );
        for ( Department department : departments ) {
            list.add( toDto( department ) );
        }

        return list;
    }
}
