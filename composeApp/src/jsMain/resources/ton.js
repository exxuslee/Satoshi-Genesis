const tonConnectUI = new TON_CONNECT_UI.TonConnectUI({
    manifestUrl: 'https://exxuslee.github.io/Satoshi-Genesis/tonconnect-manifest.json'
});
const {toUserFriendlyAddress} = TonConnectSDK;

async function start() {
    return new Promise((resolve, reject) => {
        try {
            if (tonConnectUI.connected) {
                tonConnectUI.getWallets().then(walletsList => {
                    console.log('walletsList', walletsList);
                    tonConnectUI.disconnect();
                });
            }

            tonConnectUI.uiOptions = {
                twaReturnUrl: 'https://exxuslee.github.io/Satoshi-Genesis',
            };

            tonConnectUI.openModal().then(() => {
                const unsubscribeModal = tonConnectUI.onModalStateChange(
                    (state) => {
                        if (tonConnectUI.connected) {
                            const rawAddress = tonConnectUI.wallet.account.address;
                            const bouncableUserFriendlyAddress = toUserFriendlyAddress(rawAddress);
                            console.log(state, bouncableUserFriendlyAddress);
                            resolve(bouncableUserFriendlyAddress);
                        }
                    }
                );
            });
        } catch (error) {
            reject(error);
        }
    });
}

start().then(address => address).catch(error => console.error(error));