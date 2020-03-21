//Show hide loading due to a asyncronous ajax call
function ShowLoading(block) {
    if (block) {
        //$.blockUI();
        $.blockUI({
            message: "<img src='" + baseUrl + "/Content/images/wait.gif' />",
            css: {
                top: ($(window).height() - 32) / 2 + 'px',
                left: ($(window).width() - 32) / 2 + 'px',
                width: '32px',
                height: '32px'
            }
        });
    } else {
        $.unblockUI();
    }
}