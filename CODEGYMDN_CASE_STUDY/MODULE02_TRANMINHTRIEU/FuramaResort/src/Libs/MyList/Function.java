package Libs.MyList;

import Models.persons.Employees;

import java.util.*;

public class Function {
    public static void display(){
        Map<String, Employees> employeeMap;
        employeeMap = new HashMap<>();
        employeeMap.put("E-001", new Employees("001", "Trần Minh Triều", "32", "123456789"));
        employeeMap.put("E-002", new Employees("002", "Lê Ngọc Huy", "25", "125856789"));
        employeeMap.put("E-003", new Employees("003", "Nguyễn Văn Kiến Đen", "22", "123659847"));
        employeeMap.put("E-004", new Employees("004", "Lê Đình Quốc", "7", "123584692"));
        employeeMap.put("E-005", new Employees("005", "Trương Văn Toàn", "4", "0236594856"));
        employeeMap.put("E-006", new Employees("006", "Tống Công Minh", "20", "26532546"));
        employeeMap.put("E-007", new Employees("007", "Nguyễn Duy Vũ", "22", "1236958745"));
        employeeMap.put("E-008", new Employees("008", "Mai Quốc Việt", "3", "12365985"));
        employeeMap.put("E-009", new Employees("009", "Nguyễn Duy Hiền", "22", "123658459"));
        employeeMap.put("E-010", new Employees("010", "Lâm Văn Hùng", "22", "203265925"));
        employeeMap.put("E-011", new Employees("011", "Trần Minh Triều", "42", "1230006789"));
        //List<Employees> allKey = new ArrayList<>(emploeeyMap.values());
        List<Employees> employees = new ArrayList<>(employeeMap.values());
        List<String> listE = new ArrayList<>();

        //employees.forEach(e->);
        //listE = (List<String>) employees().filter(e ->Integer.parseInt(e.getAge())>20);
//        for (Employees employee : employees) {
//            System.out.println("--------------------------------------------------------------");
//            System.out.println(employee.showInfor());
//            System.out.println();
//        }.

//        employeeMap.forEach((k,val) -> {
//            listE.add(k);
//        });

        //employeeMap.values().stream().

        for (String item : listE) {
            System.out.println(item);
        }
//        Collections.sort(listE);
    }
}
