// HikeList.js
// import { useNavigate } from 'react-router-dom';
import React, { useEffect, useState } from 'react';
import './historystyles.css';

const HikeList = ({ hikes, onEdit }) => {
  const [data, setData] = useState([]);
  const [userId]= useState(1);
  
   // const navigate = useNavigate();
   const urlTrips = `http://localhost:8080/trips/all/${userId}`;
 

  // Fetching trail_blazer trips database
  const fetchInfo = async () => {
    await fetch(urlTrips)
      .then((res) => res.json())
      .then((d) => setData(d));
  };

  useEffect(() => {
    fetchInfo();
  }, []);

  const reverseOrder = data.sort((a, b) => (a.id < b.id ? 1 : -1));

  return (
    <div>
      <h2>Hike List</h2>
      <h3>Just Added</h3>
      <div className="hike-list-container">
        {hikes.map((hike) => (
          <div key={hike.id} className="hike-card">
            <strong>{hike.tripName}</strong>
            <p>Trail Location: {hike.location}</p>
            <p>Hike Date: {hike.date}</p>
            <p>Hike Notes: {hike.notes}</p>
          </div>
        ))}
      </div>
      <h3>Saved Trips</h3>
      <div className="hike-list-container">
        {reverseOrder.map((trip) => (
          <div key={trip.id} className="hike-card">
            <strong>{trip.tripName}</strong>
            <p style={{ display: "none" }}>{trip.id}</p>
            <p>Trail Location: {trip.location}</p>
            <p>Hike Date: {trip.date}</p>
            <p>Hike Notes: {trip.notes}</p>
            <div>
              {" "}
              <p>Plants Found:</p>{" "}
              {trip.plants.map((plant) => (
                <span key={plant.id}>
                  <span>{plant.scientificName} | </span>
                </span>
              ))}
            </div>
            <div>
              {" "}
              <p>Animals Found:</p>{" "}
              {trip.fauna.map((animal) => (
                <span key={animal.id}>
                  <span>{animal.commonName} | </span>
                </span>
              ))}
            </div>
            <button class="btn-edit" id={trip.id} onClick={() => onEdit(trip, console.log(trip))}>
              Edit
            </button>
            <button
              onClick={() => {
                const urlDelete =
                  "http://localhost:8080/trips/delete/" + trip.id;
                let text = "Are you sure you want to delete this trip?";
                // eslint-disable-next-line no-restricted-globals
                if (confirm(text) === true) {
                  fetch(urlDelete, { method: "DELETE" })
                    .then((response) => {
                      if (!response.ok) {
                        throw new Error("Something went wrong");
                      }
                      window.location.reload(false);
                    })
                    .catch((e) => {
                      console.log(e);
                    });
                } else {
                  return null;
                }
              }}
            >
              Delete
            </button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default HikeList;
