
const tonConnectUI = new TON_CONNECT_UI.TonConnectUI({
    manifestUrl: 'https://exxuslee.github.io/Satoshi-Genesis/tonconnect-manifest.json'
});

tonConnectUI.uiOptions = {
    twaReturnUrl: 'https://https://exxuslee.github.io/Satoshi-Genesis',
};

tonConnectUI.openModal().then(() => {
    console.log('Modal opened');
});