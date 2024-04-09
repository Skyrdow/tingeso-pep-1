import React, { useState } from 'react';
import { Car } from '../types';
import httpCommons from '../http-commons';

const AddCar = () => {
    const [carData, setCarData] = useState<Car>({
        patent: "",
        brand: "",
        model: "",
        fabDate: new Date(),
        mileage: 0,
        seatCount: 0,
        motorType: undefined,
        carType: undefined,
    });

    const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setCarData({
            ...carData,
            [e.target.name]: e.target.value,
        });
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
    
        httpCommons.postCar(carData).then((response) => {
            console.log(response.data);
        }).catch((e) => {
            console.log(e);
        });

    return (
        <form onSubmit={handleSubmit}>
            <label>
                Marca:
                <input
                    type="text"
                    name="make"
                    value={carData?.brand}
                    onChange={handleInputChange}
                />
            </label>
            <br />
            <label>
                Modelo:
                <input
                    type="text"
                    name="model"
                    value={carData.model}
                    onChange={handleInputChange}
                />
            </label>
            <br />
            <label>
                Año:
                <input
                    type="text"
                    name="year"
                    value={carData.year}
                    onChange={handleInputChange}
                />
            </label>
            <br />
            <button type="submit">Agregar Carro</button>
        </form>
    );
};

export default AddCar;