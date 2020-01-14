package Commons;
import Models.persons.Customers;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class ValidateData {
    //tên dịch vụ, kiểu thuê, tiêu chuẩn phòng
    private static String pattern = "";
    private static Pattern regex;
    public static String genderPerson;

    //region validate villa
    public static boolean validateNameService(String name) {
        pattern = ("^[A-Z][a-z]+(?:[\\s]+[A-Z][a-z]+)*$");
        regex = Pattern.compile(pattern);
        if (name.matches(String.valueOf(regex))) {
            return true;
        }
        System.out.println("Tên Viết không dấu và in hoa ký tự đầu tiên");
        return false;
    }

    //diện tích sử dụng
    public static boolean validateAreaUsedAndPool(double areaUsed) {
        if (areaUsed > 30) {
            return true;
        } else {
            System.out.println("diện tích sử dụng phải là số thực và lớn hơn 30m^2 ");
            return false;
        }
    }

    //chi phí thuê
    public static boolean validateRentalCosts(double rentalCosts) {
        if (rentalCosts > 0) {
            return true;
        } else {
            System.out.println("Chi phí thuê phải là số thực dương ");
            return false;
        }
    }

    //số lượng người đi tối đa
    public static boolean validateNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople > 0 && numberOfPeople < 20) {
            return true;
        } else {
            System.out.println("Số lượng người phải là số nguyên dương và nhỏ hơn 20 ");
            return false;
        }
    }

    //số lượng tầng
    public static boolean validatenumberOfFloor(int numberOfFloor) {
        if (numberOfFloor > 0) {
            return true;
        } else {
            System.out.println("Số lượng tầng phải là số nguyên dương ");
            return false;
        }
    }
    //endregion

    //region validate customer
    //tên
    public static boolean validateCustomerName(String name) {
        pattern = ("^[A-Z][a-z_àáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]" +
                "+(?:[\\s]+[A-Z][a-z_àáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]+)*$");
        regex = Pattern.compile(pattern);
        if (name.matches(String.valueOf(regex))) {
            return true;
        }
        System.out.println("Tên khách hàng tiếng việt và in hoa ký tự đầu tiên");
        return false;
    }

    //ngày sinh
    public static boolean validateBirthday(String birthday) {
        pattern = ("^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4}$");
        regex = Pattern.compile(pattern);
        String date = "";
        if (birthday.matches(String.valueOf(regex))) {
            LocalDateTime timeNow = LocalDateTime.now();
            for (int i = birthday.length()-4; i<birthday.length();i++) {
                date+= birthday.charAt(i);
            }
            if (timeNow.getYear() - Integer.parseInt(date) > 18) {
                return true;
            }
        }
        System.out.println("ngày tháng phải đúng định dạng dd-mm-yyyy");
        return false;

    }

    //Dịch vụ đi kèm
    public static boolean validateAccompaniedService(String accompaniedService) {
        pattern = ("");
        regex = Pattern.compile(pattern);
        if (accompaniedService.matches(String.valueOf(regex))) {
            return true;
        }
        System.out.println("Dịch vụ đi kèm phải là: ");
        return false;
    }

    // kiểm tra email
    public static boolean validateEmail(String email) {
        pattern = ("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
        regex = Pattern.compile(pattern);
        if (email.matches(String.valueOf(regex))) {
            return true;
        }
        System.out.println("Email phải đúng định dạng abc@abc.abc");
        return false;
    }

    // kiểm tra IDCard
    public static boolean validateIDCard(String idCard) {
        pattern = ("^([0-9]{9})$");
        regex = Pattern.compile(pattern);
        if (idCard.matches(String.valueOf(regex))) {
            return true;
        }
        System.out.println("ID card phải đúng 9 chữ số");
        return false;
    }

    public static boolean validateGender(String gender) {
        pattern = ("^(male)|(female])|(unknow)$");
        regex = Pattern.compile(pattern);
        if (gender.matches(String.valueOf(regex))) {
            String[] arr = gender.split("");
            genderPerson = "";
            for (int i = 0; i < arr.length; i++) {
                if (i == 0) {
                    genderPerson += arr[0].toUpperCase();
                } else {
                    genderPerson += arr[i];
                }
            }
            return true;
        }
        System.out.println("Gender phải là Male, Female or Unknow");
        return false;
    }

    public static boolean validatePhone(String phone) {
        //System.out.println("Phone yourself");
        return true;
    }
    //endregion
}

