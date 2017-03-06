function goPage(path, action, page) {
	location.href=path+'?action='+action+'&page='+page;
}

function goList(path, action, page, pageNO) {
	location.href=path+'?action='+action+'&page='+page+'&pageNO='+pageNO;
}
