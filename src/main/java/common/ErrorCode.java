package common;

public enum ErrorCode {
    PRODUCT_NOT_FOUND(404, "해당 상품을 찾을 수 없습니다.");

    private final int status;
    private final String message;

    ErrorCode(int status, String message){
        this.status = status;
        this.message = message;
    }

    public int getStatus(){
        return this.status;
    }

    public String getMessage(){
        return this.message;
    }
}