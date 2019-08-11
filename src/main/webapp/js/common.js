/**
 * 选择cur相邻的size个数,返回其[start,end].
 * @param cur
 * @param size
 * @param total
 */
function chooseEndpoint(cur, size, total) {
    var start, end;
    if (size > total) {
        return [1, total];
    }
    start = cur - size / 2;
    end = start + size - 1;
    if (start < 1){
        return [1, size];
    }
    if (end > total) {
        return [total - size + 1,total];
    }
    return [start, end];
}

/**
 * 根据传递过来的参数name获取url中对应的值
 * @param name
 * @returns {string|null}
 */
function getParameter(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    var r = location.search.substr(1).match(reg);
    if (r!=null) return (r[2]); return null;
}