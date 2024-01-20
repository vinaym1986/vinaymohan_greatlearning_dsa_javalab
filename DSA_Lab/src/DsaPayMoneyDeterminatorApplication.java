import com.greatlearning.paymoney.service.PayMoneyTargetDeterminator;

public class DsaPayMoneyDeterminatorApplication {

    public static void main(String[] args) {

        PayMoneyTargetDeterminator determinator =
                new PayMoneyTargetDeterminator();
        determinator.determine();

    }
}

