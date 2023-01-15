import React from "react";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import AuthProvider, { useAuth } from "./security/AuthContext";
import LoginComponent from "./LoginComponent";
import "./ToDoApp.css";
import { WelcomeComponent } from "./WelcomeComponent";
import ErrorComponent from "./ErrorComponent";
import ListToDo from "./ListToDo";
import HeaderComponent from "./HeaderComponent";
import FooterComponent from "./FooterComponent";
import LogOutComponent from "./LogOutComponent";
import TodoComponent from "./TodoComponent";

const AuthenticationRouter = ({ children }) => {
  const authContext = useAuth();
  if (authContext.isAuthenticated) {
    return children;
  }
  return <Navigate to="/" />;
};

const TodoApp = () => {
  return (
    <div className="TodoApp">
      <AuthProvider>
        <BrowserRouter>
          <HeaderComponent />
          <Routes>
            <Route path="/" element={<LoginComponent />} />
            <Route path="/login" element={<LoginComponent />} />
            <Route
              path="/welcome/:username"
              element={
                <AuthenticationRouter>
                  <WelcomeComponent />
                </AuthenticationRouter>
              }
            />
            <Route
              path="/todos"
              element={
                <AuthenticationRouter>
                  <ListToDo />
                </AuthenticationRouter>
              }
            />
            <Route
              path="/todos/:id"
              element={
                <AuthenticationRouter>
                  <TodoComponent />
                </AuthenticationRouter>
              }
            />
            <Route
              path="/logout"
              element={
                <AuthenticationRouter>
                  <LogOutComponent />
                </AuthenticationRouter>
              }
            />
            <Route path="*" element={<ErrorComponent />} />
          </Routes>
          <FooterComponent />
        </BrowserRouter>
      </AuthProvider>
    </div>
  );
};

export default TodoApp;
