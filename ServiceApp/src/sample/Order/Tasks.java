package sample.Order;

public class Tasks {
    private String address;
    private String phone;
    private String spec;
    private String tittle;
    private String note;
    private String date;
    private int id;
    public Tasks(int id,String address,String phone,String spec,String tittle,String note,String date){
        this.id=id;
        this.address=address;
        this.phone=phone;
        this.spec=spec;
        this.tittle=tittle;
        this.note=note;
        this.date=date;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getSpec() {
        return spec;
    }

    public String getTittle() {
        return tittle;
    }

    public String getNote() {
        return note;
    }

    public String getDate() {
        return date;
    }
}
