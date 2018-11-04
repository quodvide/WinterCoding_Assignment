function $(selector) {
    return document.querySelector(selector);
}

function fetchManager({url, method, body, headers, callback, errCallback}) {
    fetch(url, {method, body, headers, credentials: "same-origin"})
        .then((response) => {
            if (response.status === 200 || response.status === 201 || response.status === 302) {
                callback(response);
                return false;
            } else {
                errCallback(response);
            }
        })
}

function loadTodos() {
    fetchManager({
        url: '/api/todos',
        method: 'GET',
        headers: { 'content-type': 'application/json'},
        callback: onSuccessLoad,
        errCallback: onFailLoad
    })
}

function onSuccessLoad(contents) {
console.log(contents)
    let contentHTML = '';
    contents.json().then((contentsList) => {
        contentsList.forEach((content) => {
        console.log(content)
        console.log(content.content)
            contentHTML += `<li class="ui-state-default">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="" />${content.title} : ${content.content}
                                    </label>
                                </div>
                            </li>`
        })
        $("#todoList").insertAdjacentHTML("afterbegin", contentHTML);
    })


}

function onFailLoad() {
    console.log("Fail to Load Todolist")
}

document.addEventListener("DOMContentLoaded", function() {
    loadTodos();
});
