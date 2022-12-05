package com.znsio.sample.e2e.screen.indigo;

import com.znsio.e2e.entities.Platform;
import com.znsio.e2e.runner.Runner;
import com.znsio.e2e.tools.Driver;
import com.znsio.e2e.tools.Visual;
import com.znsio.sample.e2e.screen.android.indigo.GiftVoucherPreviewScreenAndroid;
import com.znsio.sample.e2e.screen.web.indigo.GiftVoucherPreviewScreenWeb;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.log4j.Logger;

import static com.znsio.e2e.runner.Runner.fetchDriver;
import static com.znsio.e2e.runner.Runner.fetchEyes;

public abstract class GiftVoucherPreviewScreen {

    private static final String SCREEN_NAME = GiftVoucherPreviewScreen.class.getSimpleName();
    private static final Logger LOGGER = Logger.getLogger(SCREEN_NAME);

    public static GiftVoucherPreviewScreen get() {
        Driver driver = fetchDriver(Thread.currentThread()
                .getId());
        Platform platform = Runner.fetchPlatform(Thread.currentThread()
                .getId());
        LOGGER.info(SCREEN_NAME + ": Driver type: " + driver.getType() + ": Platform: " + platform);
        Visual visually = fetchEyes(Thread.currentThread()
                .getId());

        switch(platform) {
            case android:
                 return new GiftVoucherPreviewScreenAndroid(driver, visually);
            case web:
                return new GiftVoucherPreviewScreenWeb(driver, visually);
        }
        throw new NotImplementedException(SCREEN_NAME + " is not implemented in " + Runner.platform);
    }

    public abstract int setAndFetchTheAmountBasedOnDenominationAnQuantity(String denomination,String qnty) ;
    public abstract GiftVoucherPreviewScreen personalizeGiftVoucher();
    public abstract GiftVoucherPreviewScreen clickOnPreview();
    public abstract boolean checkPersonalizationOfGiftVoucher();
    public abstract GiftVoucherPreviewScreen clickOnProceed();
    public abstract GiftVoucherPreviewScreen applyInvalidPromocode();
    public abstract String fetchInvalidPromoCodeMessage();
    public abstract int fetchTotalAmountAfterApplyingThePromoCode();
    public abstract GiftVoucherPreviewScreen setDeliveryOptions();
    public abstract PaymentDetailsScreen clickOnPayNow();

}
