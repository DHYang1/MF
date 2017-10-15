package mf.pojo;

public class DesignerWallet {
    private Long designerId;

    private Double incomeCount;

    private Double expenditureCount;

    private Double balance;

    public Long getDesignerId() {
        return designerId;
    }

    public void setDesignerId(Long designerId) {
        this.designerId = designerId;
    }

    public Double getIncomeCount() {
        return incomeCount;
    }

    public void setIncomeCount(Double incomeCount) {
        this.incomeCount = incomeCount;
    }

    public Double getExpenditureCount() {
        return expenditureCount;
    }

    public void setExpenditureCount(Double expenditureCount) {
        this.expenditureCount = expenditureCount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}