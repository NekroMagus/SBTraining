class Reg extends React.Component {
    render() {
        return (
            <div className="content">
                <input placeholder="Login" id="login"/>
                <input type="password" placeholder="Password" id="password"/>
                <button onClick={reg}>Зарегистрироваться</button>
            </div>
        );
    }
}
ReactDOM.render(
    <Reg></Reg>,
    document.getElementById("app")
)


function reg() {
    json =
        JSON.stringify({
            login: $('#login').val(),
            password: $('#password').val(),
        });
    $.ajax({
        url: '/registration',
        type: 'POST',
        data: json,
        contentType: 'application/json',
        cache: false,
        success: (data) => {
            if(data!="null") {
                localStorage.setItem("token","data");
                log_in(data);
            }
        },
        error: (err) => {
            console.log("Something wrong");
        }
    });
}

function log_in(token) {
    $.ajax({
        url: '/login',
        type: 'POST',
        contentType: "application/json",
        data: json,
        Authorization: "Bearer " + token,
        cache: false,
        success: (data) => {
            alert("Successful");
        },
        error: (err) => {
            console.log("no");
        }
    });
}