import httpCommons from "../http-commons";
import Car from "../components/Car";
import { useEffect, useState } from "react";
const Cars = () => {
    const [data, setData] = useState<Array<any>>([]);

    useEffect(() => {
        httpCommons.getCars().then((response) => {
            setData(response.data);
            console.log(response.data);
        }).catch((e) => {
            console.log(e);
        });
    }, []);
    return (
        <div>
            <h1>Cars</h1>
            
                <h2>List of cars</h2>
                <ul className="">
                    {data.map((car: any) => (
                        <Car data={car} />
                    ))}
                </ul>
            
        </div>
    )
}

export default Cars;