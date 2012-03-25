/**
 * Created by IntelliJ.
 * User: mario
 * Date: 23/02/12
 * Time: 0:35
 */

var Admin = {
    /**
     * Get All the entities in JSON format, and use a template to show them to the client
     * @param url
     * @param holder
     * @param template
     * @param callback
     */
    all:function (url, holder, template, callback) {
        holder.empty();
        $.getJSON(url, function (result) {
            holder.append(Mustache.to_html(template.html(), {items:result}));
            callback()
        })
    },
    /**
     * Show a modal Form
     * @param url
     * @param modal
     */
    formModal:function (url, modal) {
        var holder = modal.find('.modal-body');
        holder.empty();
        holder.load(url);
        modal.modal()
    }
};
