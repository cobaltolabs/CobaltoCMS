/**
 * Created by IntelliJ.
 * User: mario
 * Date: 23/02/12
 * Time: 0:35
 */

var Admin = {
    all:function (url, holder, template, callback) {
        holder.empty();
        $.getJSON(url, function (result) {
            holder.append(Mustache.to_html(template.html(), {items:result}));
            callback()
        })
    },
    formModal:function (url, modal) {
        var holder = modal.find('.modal-body');
        holder.empty();
        holder.load(url);
        modal.modal()
    }
};
