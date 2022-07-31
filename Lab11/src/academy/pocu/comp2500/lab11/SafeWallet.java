package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;

public class SafeWallet extends Wallet {

    public SafeWallet(User user) throws IllegalAccessException {
        super(user);
    }

    @Override
    public boolean deposit(final int amount) {
        if (amount <= 0) {
            return false;
        }

        int sum = super.getAmount() + amount;
        if (sum <= 0) {
            throw new OverflowException("overflow");
        }

        if (super.deposit(amount)) {
            return true;
        } else {
            return false;
        }
    }
}
