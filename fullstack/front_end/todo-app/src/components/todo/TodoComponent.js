import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import {
  retrieveTodoApi,
  updateTodoApi,
  addToDoApi,
} from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { Formik, Form, Field, ErrorMessage } from "formik";
const TodoComponent = () => {
  const authContext = useAuth();
  const username = authContext.username;
  const [description, setDescription] = useState("Enter your desc");
  const [targetDate, setTargetDate] = useState("2023-01-14");
  const { id } = useParams();
  const navigate = useNavigate();
  const retrieveTodo = () => {
    if (id !== -1) {
      retrieveTodoApi(username, id)
        .then((res) => {
          setDescription(res.data.description);
          setTargetDate(res.data.targetDate);
        })
        .catch((err) => console.log(err));
    }
  };

  const validate = (values) => {
    let errors = {};
    if (values.description.length < 5) {
      errors.description = "Enter a valid description";
    }
    if (Date.parse(values.targetDate) < new Date()) {
      errors.targetDate = "Enter the valid date";
    }
    return errors;
  };

  useEffect(() => {
    retrieveTodo();
  }, [id]);

  const handleSubmit = (values) => {
    if (id == -1) {
      const newtodo = {
        username: username,
        description: values.description,
        targetDate: values.targetDate,
        done: false,
      };
      addToDoApi(username, newtodo)
        .then(() => {
          navigate("/todos");
        })
        .catch((error) => console.log(error));
    } else {
      const todo = {
        description: values.description,
        targetDate: values.targetDate,
      };
      updateTodoApi(username, id, todo)
        .then(() => {
          navigate(`/todos`);
        })
        .catch((error) => console.log(error));
    }
  };
  return (
    <div className="container">
      <h1>Enter Todo Details</h1>
      <div>
        <Formik
          initialValues={{ description, targetDate }}
          enableReinitialize={true}
          onSubmit={handleSubmit}
          validate={validate}
          validateOnChange={false}
          validateOnBlur={false}
        >
          {(props) => (
            <Form>
              <ErrorMessage
                name="description"
                component="div"
                className="alert alert-warning"
              />
              <ErrorMessage
                name="targetDate"
                component="div"
                className="alert alert-warning"
              />
              <fieldset className="form-group">
                <label>Description</label>
                <Field
                  type="text"
                  className="form-control"
                  name="description"
                />
              </fieldset>
              <fieldset className="form-group">
                <label>Target Date</label>
                <Field type="date" className="form-control" name="targetDate" />
              </fieldset>
              <div>
                <button className="btn btn-success m-5" type="submit">
                  Save
                </button>
              </div>
            </Form>
          )}
        </Formik>
      </div>
    </div>
  );
};

export default TodoComponent;
