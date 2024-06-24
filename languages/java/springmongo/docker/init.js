db = db.getSiblingDB('workshop-mongo');

db.createCollection('user');

db.createUser({
    user: 'local',
    pwd: '12345',
    roles: [{ role: 'readWrite', db: 'workshop-mongo' }]
});
