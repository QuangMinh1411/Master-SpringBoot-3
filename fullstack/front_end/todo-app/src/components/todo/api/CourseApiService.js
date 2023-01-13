import axios from "axios";

const apiClient = axios.create({
  baseURL: "http://localhost:8080",
});
export const retrieveCourses = () => {
  return apiClient.get("/courses");
};

export const getCourse = (id) => {
  return apiClient.get(`/courses/${id}`);
};
