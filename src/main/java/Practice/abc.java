package Practice;

public class abc {

        private String name;
        private int salary;

        public void setName( String n){
            name=n;
        }
        public String getName(){
            return name;
        }

        public void setSalary (int sa){
            if(sa>=10){
                salary=sa;
            }
            else {
                System.out.println("Salary is very low");
            }

        }
        public int getSalary(){
            return salary;
        }

    }


