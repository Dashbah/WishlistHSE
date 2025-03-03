package dashbah.wishlistapp.exception;

public class GiftNotFoundException extends Exception {

    public GiftNotFoundException() {
        super();
    }

    public GiftNotFoundException(String giftUId) {
        super(String.format("Gift not found with giftUId = %s", giftUId));
    }
}
