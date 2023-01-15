import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { retrievedAllToDosForUser, deleteTodoApi } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
const ListToDo = () => {
  const authContext = useAuth();

  const username = authContext.username;

  const navigate = useNavigate();

  const [todos, setTodos] = useState([]);

  const [message, setMessage] = useState(null);

  function refreshTodos() {
    retrievedAllToDosForUser(username)
      .then((response) => {
        setTodos(response.data);
      })
      .catch((error) => console.log(error));
  }
  const deleteTodo = (id) => {
    deleteTodoApi(username, id)
      .then(() => {
        setMessage(`Delete todo with id: ${id} successfull`);
        setTimeout(() => setMessage(null), 3000);
        refreshTodos();
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const updateTodo = (id) => {
    navigate(`/todos/${id}`);
  };

  const addNewToDo = () => {
    navigate("/todos/-1");
  };

  useEffect(() => {
    refreshTodos();
  }, []);

  const list = todos.map((todo) => (
    <tr key={todo.id}>
      <td>{todo.description}</td>
      <td>{todo.done ? "Done" : "In progress"}</td>
      <td>{todo.targetDate}</td>
      <td>
        <button
          className="btn btn-warning mx-5"
          onClick={() => deleteTodo(todo.id)}
        >
          Delete
        </button>
        <button className="btn btn-success" onClick={() => updateTodo(todo.id)}>
          Update
        </button>
      </td>

      <td></td>
    </tr>
  ));
  return (
    <div className="container">
      <h1>Things you want to do</h1>
      {message && <div className="alert alert-warning">{message}</div>}

      <table className="table">
        <thead>
          <tr>
            <th>Description</th>
            <th>Done</th>
            <th>Target Date</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>{list}</tbody>
      </table>
      <div className="btn btn-success m-5" onClick={addNewToDo}>
        Add new Todo
      </div>
    </div>
  );
};

export default ListToDo;
