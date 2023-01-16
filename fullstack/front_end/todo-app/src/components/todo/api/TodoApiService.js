import { apiClient } from "./ApiClient";

export const retrievedAllToDosForUser = (username) => {
  return apiClient.get(`/users/${username}/todos`);
};

export const deleteTodoApi = (username, id) => {
  return apiClient.delete(`/users/${username}/todos/${id}`);
};

export const updateTodoApi = (username, id, todo) => {
  return apiClient.put(`/users/${username}/todos/${id}`, todo);
};

export const retrieveTodoApi = async (username, id) => {
  return await apiClient.get(`/users/${username}/todos/${id}`);
};

export const addToDoApi = async (username, todo) => {
  return await apiClient.post(`/users/${username}/todos`, todo);
};
