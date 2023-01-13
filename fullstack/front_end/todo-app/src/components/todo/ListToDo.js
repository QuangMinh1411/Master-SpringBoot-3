import React, { useEffect, useState } from "react";
import { retrievedAllToDosForUser } from "./api/TodoApiService";

const ListToDo = () => {
  // const today = new Date();
  // const target = new Date(
  //   today.getFullYear() + 12,
  //   today.getMonth(),
  //   today.getDay()
  // );
  // const todos = [
  //   {
  //     id: 1,
  //     description: "Learn AWS",
  //     done: false,
  //     targetDate: target,
  //   },
  //   {
  //     id: 2,
  //     description: "Learn Java",
  //     done: false,
  //     targetDate: target,
  //   },
  //   {
  //     id: 3,
  //     description: "Learn Docker",
  //     done: false,
  //     targetDate: target,
  //   },
  // ];

  const [todos, setTodos] = useState([]);

  const refreshTodo = () => {
    retrievedAllToDosForUser("heavenlight")
      .then((res) => setTodos(res.data))
      .catch((err) => console.log(err));
  };

  useEffect(() => {
    refreshTodo();
  }, []);

  const list = todos.map((todo) => (
    <tr key={todo.id}>
      <td>{todo.id}</td>
      <td>{todo.description}</td>
      <td>{todo.done ? "Done" : "In progress"}</td>
      <td>{todo.targetDate}</td>
    </tr>
  ));
  return (
    <div className="container">
      <h1>Things you want to do</h1>
      <table className="table">
        <thead>
          <tr>
            <td>Id</td>
            <td>Description</td>
            <td>Done</td>
            <td>Target Date</td>
          </tr>
        </thead>
        <tbody>{list}</tbody>
      </table>
    </div>
  );
};

export default ListToDo;
