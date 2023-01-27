use moody;

insert into user(user_name, password) values ('hyunblee', '{bcrypt}$2a$10$4kWzwruKCB.0KtXOwYIlbe0rThqMI6e0pHFeZszpWnd2cPe1mgH3q');
insert into heatmap(date, feeling, user_id) values ("20230101", 0, 1);
insert into heatmap(date, feeling, user_id) values ("20230102", 0, 1);
insert into heatmap(date, feeling, user_id) values ("20230103", 0, 1);
insert into heatmap(date, feeling, user_id) values ("20230105", 0, 1);
insert into heatmap(date, feeling, user_id) values ("20230201", 0, 1);

insert into user(user_name, password) values ('yujin', '{bcrypt}$2a$10$4kWzwruKCB.0KtXOwYIlbe0rThqMI6e0pHFeZszpWnd2cPe1mgH3q');
insert into heatmap(date, feeling, user_id) values ("20230101", 2, 2);
insert into heatmap(date, feeling, user_id) values ("20230102", 2, 2);
insert into heatmap(date, feeling, user_id) values ("20230103", 2, 2);
insert into heatmap(date, feeling, user_id) values ("20230105", 2, 2);
insert into heatmap(date, feeling, user_id) values ("20230201", 2, 2);


insert into quote(saying) values ("타인이 널 어떻게 느끼는지는 너가 관여할 수 없는 것이다. 그러니 바꾸려하지 말고 오로지 너의 인생을 살고 행복하여라. -박신영");
insert into quote(saying) values ("과거가 얼마나 힘들었든지간에 넌 언제나 다시 시작할 수 있다. -박신영");
insert into quote(saying) values ("고통이 널 붙잡고 있는게 아니라, 너가 고통을 붙잡고 있는 것이다. -박신영");
insert into quote(saying) values ("너 자신을 극복할 수 있으면 현실에서도 승리할 수 있다. -박신영");
insert into quote(saying) values ("사람들에게 너의 계획을 말하지 말고, 결과물을 보여주어라. -박신영");
insert into quote(saying) values ("변화 그 자체는 결코 고통이 아니지만, 변화에 저항하는 것은 고통 그 자체이다. -박신영");
insert into quote(saying) values ("영원한건 아무것도 없다. 너무 스트레스를 받지 마라. 상황이 얼마나 나쁘건간에 그것은 곧 변할 것이기 때문이다. -박신영");
insert into quote(saying) values ("우리네 삶에서의 모든 상황은 그저 찰나이다. 상황이 좋지 않아도 점차 나아진다는 것을 기억하면 된다. -박신영");
insert into quote(saying) values ("타인이 너를 무엇으로 생각하는지는 중요치 않다. 스스로 생각하는 너 자신이 너의 모든 것이다. -박신영");
insert into quote(saying) values ("타인의 삶과 비교하지 마라. 해와 달은 서로를 비교하는 법이 없다. 그들은 단지 그들의 시간대에서 빛나고 있는 그 뿐이다. -박신영");
insert into quote(saying) values ("타인에게 영감을 주기 위해 네 인생을 살지 말고, 너 자신에게 영감을 주는 인생을 살아라. -박신영");
insert into quote(saying) values ("타인이 널 좋아하도록 자신을 바꾸지 마라. 오로지 솔직한 너 자신이 된다면 올바른 사람들은 진짜 너의 모습을 사랑하게 될 것이다. -박신영");

-- insert into member_roles(member_id, roles) values ('user', 'USER');