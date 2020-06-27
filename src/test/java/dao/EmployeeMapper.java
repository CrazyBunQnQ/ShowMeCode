package dao;

import bean.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String actorno);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String actorno);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}