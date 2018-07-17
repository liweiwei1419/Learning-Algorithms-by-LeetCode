import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution2 {

    // 广度优先遍历，使用队列

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int res = 0;
        queue.addLast(id);
        while (!queue.isEmpty()) {
            Integer curId = queue.removeFirst();
            if (!visited.contains(curId)) {
                Employee curEmp = map.get(curId);
                res += curEmp.importance;
                for (Integer eid : curEmp.subordinates) {
                    queue.addLast(eid);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.id = 1;
        employee1.importance = 5;
        List<Integer> subordinates1 = new ArrayList<>();
        subordinates1.add(2);
        subordinates1.add(3);
        employee1.subordinates = subordinates1;

        Employee employee2 = new Employee();
        employee2.id = 2;
        employee2.importance = 3;
        employee2.subordinates = new ArrayList<>();

        Employee employee3 = new Employee();
        employee3.id = 3;
        employee3.importance = 3;
        employee3.subordinates = new ArrayList<>();

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        Solution2 solution2 = new Solution2();
        int importance = solution2.getImportance(employees, 1);
        System.out.println(importance);
    }
}
