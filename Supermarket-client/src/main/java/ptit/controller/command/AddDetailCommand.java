package ptit.controller.command;

import ptit.model.ImportDetail;

import java.util.Iterator;

public class AddDetailCommand implements Command, Cloneable{
    private ImportDetail detail;

    @Override
    public void execute() {
        detail.getImportBill().getDetails().add(detail);
    }

    @Override
    public AddDetailCommand clone(){
        try {
            return (AddDetailCommand) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setDetail(ImportDetail detail) {
        this.detail = detail;
    }

    public void undo(){
        int detailCount = detail.getImportBill().getDetails().size();
        detail.getImportBill().getDetails().remove(detailCount - 1);
    }
}
