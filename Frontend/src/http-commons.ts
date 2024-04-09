import axios from 'axios';
import { Car } from './types';

const url = import.meta.env.VITE_BACKEND_URL;
const port = import.meta.env.VITE_BACKEND_PORT;


const http = axios.create({
    baseURL: `http://${url}:${port}/api/v1`,
    headers: {
        'Content-type': 'application/json',
    },
});

const getCars = () => {
    return http.get('/cars/');
}

const postCar = (data: Car) => {
    return http.post('/cars/', data);
}

const setBrandBonus = (patent: string, brandBonus: number) => {
    return http.post(`/cars/brandBonus/${patent}/${brandBonus}`);
}

const getReparations = () => {
    return http.get('/reparations/');
}

const postReparation = (data: any) => {
    return http.post('/reparations/', data);
}

const getReport1 = () => {
    return http.get('/report/1');
}
const getReport2 = () => {
    return http.get('/report/2');
}
const getReport3 = () => {
    return http.get('/report/3');
}
const getReport4 = () => {
    return http.get('/report/4');
}
export default { getCars, postCar, setBrandBonus, getReparations, postReparation, getReport1, getReport2, getReport3, getReport4};