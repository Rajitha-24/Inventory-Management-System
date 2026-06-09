package model;

public class Supplier {

    private int supplierId;
    private String supplierName;
    private String phone;

    public Supplier() {
    }

    public Supplier(String supplierName, String phone) {
        this.supplierName = supplierName;
        this.phone = phone;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}